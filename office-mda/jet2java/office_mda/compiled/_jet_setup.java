package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_setup implements JET2Template {


/**
 * groupIDWithFolder
 */
	public String getGroupIDWithFolder(String groupID) {
		return groupID.replace(".", "/");
	}


/**
 * groupIDWithUnderScore
 */
	public String getGroupIDWithUnderScore(String groupID) {
		return groupID.replace(".", "_");
	}

    public _jet_setup() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write(NL);         
    }
}
