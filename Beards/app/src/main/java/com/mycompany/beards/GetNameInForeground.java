package com.mycompany.beards;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;

import java.io.IOException;

/**
 * Created by losta_000 on 8/19/2016.
 */
public class GetNameInForeground extends AbstractGetNameTask {


    public GetNameInForeground(LoginActivity mActivity, String mScope, String mEail) {
        super(mActivity, mScope, mEail);
    }

    @Override
    protected String fetchToken() throws IOException {
        try {
            return GoogleAuthUtil.getToken(mActivity,mEmail,mScope);
        }catch (GooglePlayServicesAvailabilityException playEx){

        }catch (UserRecoverableAuthException urae ){
mActivity.startActivityForResult(urae.getIntent(),mRequest);
        }catch (GoogleAuthException fatalException){
fatalException.printStackTrace();
        }



        return null;
    }
}
