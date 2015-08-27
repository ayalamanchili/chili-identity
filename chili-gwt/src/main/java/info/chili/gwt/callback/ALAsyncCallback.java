package info.chili.gwt.callback;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import info.chili.gwt.widgets.LoadingWidget;
import info.chili.gwt.widgets.ResponseStatusWidget;

import java.util.logging.Logger;

import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.utils.JSONUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ALAsyncCallback.
 */
public abstract class ALAsyncCallback<T> implements AsyncCallback<T> {

    Logger logger = Logger.getLogger(ALAsyncCallback.class.getName());
    /**
     * The is completed.
     */
    protected Boolean isCompleted = false;
    /**
     * The loading widget.
     */
    LoadingWidget loadingWidget = new LoadingWidget();

    /**
     * Instantiates a new aL async callback.
     */
    public ALAsyncCallback() {
        loadingWidget.show();
    }

    @Override
    public void onFailure(Throwable err) {
        logger.info(err.getLocalizedMessage());
        loadingWidget.hide();
        logger.info(err.getMessage());
        if (!err.getMessage().isEmpty() && err.getMessage().contains("Error")) {
            try {
                JSONValue errors = JSONParser.parseLenient(err.getMessage());
                processErrors(errors);
            } catch (Exception e) {
                new ResponseStatusWidget().show(getFailureMessage());
            }
        } else {
            new ResponseStatusWidget().show(getFailureMessage());
        }
    }

    protected void processErrors(JSONValue errorsObj) {
        logger.info("in errorrss");
        JSONArray errorsArray = JSONUtils.toJSONArray(errorsObj.isObject().get("Error"));
        String errorMessage = "";
        for (int i = 0; i < errorsArray.size(); i++) {
            JSONObject err = (JSONObject) errorsArray.get(i);
            errorMessage = errorMessage.concat(JSONUtils.toString(err, "description"));
            errorMessage = errorMessage.concat("\n");
        }
        new ResponseStatusWidget().show(errorMessage);
    }

    public abstract void onResponse(T arg0);

    public void onSuccess(T arg0) {
        loadingWidget.hide();
        onResponse(arg0);
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
    public String getFailureMessage(){
        return "Call Failed";
    }
}
