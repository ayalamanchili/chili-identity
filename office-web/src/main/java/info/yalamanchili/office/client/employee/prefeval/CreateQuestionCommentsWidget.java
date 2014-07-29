/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class CreateQuestionCommentsWidget extends Composite {

    protected FlowPanel panel = new FlowPanel();

    public CreateQuestionCommentsWidget() {
        initWidget(panel);
    }

    public void loadQuestions() {
        HttpService.HttpServiceAsync.instance().doGet(getQuestionsUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("no results");
                        } else {
                            //TODO use size and entities attributes
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            populateQuestion(results);
                        }
                    }
                });
    }

    protected void populateQuestion(JSONArray questions) {
        for (int i = 0; i < questions.size(); i++) {
            JSONObject obj = (JSONObject) questions.get(i);
            panel.add(new CreateQuestionCommentWidget(obj));
        }

    }

    protected String getQuestionsUrl() {
        return OfficeWelcome.instance().constants.root_url() + "question/query/0/100?category=" + QuestionCategory.ATTITUDE.name() + "&context=" + QuestionContext.PERFORMANCE_EVALUATION_MANGER.name();
    }

}
