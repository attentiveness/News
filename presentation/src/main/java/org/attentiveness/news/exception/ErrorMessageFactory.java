package org.attentiveness.news.exception;

import android.content.Context;

import org.attentiveness.news.R;
import org.attentiveness.news.data.exception.NetworkConnectionException;

/**
 * Error Message Factory
 */
public class ErrorMessageFactory {

    public ErrorMessageFactory() {
        //empty
    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);
        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        }
        return message;
    }

}
