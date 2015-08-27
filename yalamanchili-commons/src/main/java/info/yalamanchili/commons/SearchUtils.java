package info.yalamanchili.commons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

public class SearchUtils {

    private static final Log log = LogFactory.getLog(SearchUtils.class);

    public static String getSearchQueryString(Class cls, String searchString) {
        StringBuilder query = new StringBuilder();
        query.append("FROM " + cls.getCanonicalName() + " WHERE ");
        String[] fields = ReflectionUtils.getBeanProperties(cls, DataType.STRING);
        List<String> filters = new ArrayList<String>();
        for (String field : fields) {
            filters.add(field + " LIKE '%" + searchString.trim() + "%'");
        }
        int i = 0;
        for (String filter : filters) {
            query = query.append(filter);
            i++;
            if (i < filters.size()) {
                query = query.append(" OR ");
            }
        }
        log.info("search query String:" + query);
        return query.toString();
    }

    public static <T> String getSearchQueryString(T entity) {
        String query = "FROM " + entity.getClass().getCanonicalName() + " WHERE ";
        List<String> filters = new ArrayList<String>();
        for (Field field : ReflectionUtils.getAllFields(entity.getClass())) {
            if (!DataType.DEFAULT.equals(ReflectionUtils.getDataType(field))) {
                for (Method method : entity.getClass().getMethods()) {
                    if (method.getName().compareToIgnoreCase("get" + field.getName()) == 0) {
                        try {
                            Object o = method.invoke(entity, null);
                            if (o instanceof String && o != null) {
                                filters.add(field.getName() + " LIKE '%" + o.toString().trim() + "%'");
                            }
                            if (o instanceof Long && o != null) {
                                filters.add(field.getName() + " = " + o.toString().trim());
                            }
                            if (o instanceof Integer && o != null) {
                                filters.add(field.getName() + " = " + o.toString().trim());
                            }
                            if (o instanceof Float && o != null) {
                                filters.add(field.getName() + " = " + o.toString().trim());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
        int i = 0;
        for (String filter : filters) {
            query = query.concat(filter);
            i++;
            if (i < filters.size()) {
                query = query.concat(" AND ");
            }
        }
        log.info("query String" + query);
        return query;
    }

    public static Query getLuceneQuery(String searchText, StandardAnalyzer anaylyzer, String... fields) {
        MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_30, fields, new StandardAnalyzer(
                Version.LUCENE_30));
        org.apache.lucene.search.Query luceneQuery = null;
        try {
            luceneQuery = parser.parse(getSearchQuery(searchText, fields));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return luceneQuery;
    }

    /*
     * this is a temp method to get around.
     * http://littlesquare.com/2010/05/upgrading
     * -to-hibernate-search-3-2-0-w-seam/
     */
    public static FullTextSession getFullTextSession(EntityManager em) {
        Session session = (Session) em.getDelegate();
        return Search.getFullTextSession(session.getSessionFactory().getCurrentSession());
    }

    // TODO fix issue with empty string
    /**
     * Caused by: org.apache.lucene.queryParser.ParseException: Cannot parse '':
     * Encountered "<EOF>" at line 1, column 0. Was expecting one of: <NOT> ...
     * "+" ... "-" ... "(" ... "*" ... <QUOTED> ... <TERM> ... <PREFIXTERM> ...
     */
    public static String getSearchQuery(String searchText, String... fields) {
        StringBuilder searchQuery = new StringBuilder();
        for (String word : splitSearchString(searchText, ' ')) {
            for (String field : fields) {
                searchQuery.append(field);
                searchQuery.append(":");
                searchQuery.append(word);
                searchQuery.append(" ");
            }
        }
        log.info("lucene search query:" + searchQuery.toString());
        return searchQuery.toString();
    }

    public static List<String> splitSearchString(String searchText, char seperator) {
        List<String> words = new ArrayList<String>();
        Scanner searchTextScanner = new Scanner(searchText);
        while (searchTextScanner.hasNext()) {
            words.add(searchTextScanner.next());
        }
        return words;
    }
}
