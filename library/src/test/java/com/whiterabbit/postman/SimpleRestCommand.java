package com.whiterabbit.postman;

import android.content.Context;
import android.os.Parcel;
import com.whiterabbit.postman.commands.RestServerCommand;
import com.whiterabbit.postman.commands.ResultParseException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

/**
 * Created with IntelliJ IDEA.
 * User: fedepaol
 * Date: 12/30/12
 * Time: 2:25 PM
 */
public class SimpleRestCommand extends RestServerCommand{
    public final String KEY = "key";
    public final String VALUE = "value";
    private String mResultString;
    private OAuthRequest mMockedRequest;

    public SimpleRestCommand(OAuthRequest request){
        super(Verb.GET, "www.google.com");
        mMockedRequest = request;
    }

    protected SimpleRestCommand(Parcel in) {
        super(in);
    }

    @Override
    protected void processHttpResult(Response result, Context context) throws ResultParseException {
        mResultString = result.getBody();
    }

    @Override
    protected void addParamsToRequest(OAuthRequest request) {
        request.addHeader("Key", "Value");
    }

    @Override
    protected OAuthRequest getRequest(Verb v, String url) {
        return mMockedRequest;
    }

    @Override
    public int describeContents() {
        return 0;  //TODO Autogenerated
    }

    public String getResultString(){
        return mResultString;
    }
}
