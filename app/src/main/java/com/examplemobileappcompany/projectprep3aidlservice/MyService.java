package com.examplemobileappcompany.projectprep3aidlservice;

import android.app.Service;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return myAidlInterface;
    }

    private final IMyAidlInterface.Stub myAidlInterface = new IMyAidlInterface.Stub(){
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String testInterface() throws RemoteException {
            return "Service Call Made";
        }


        @Override
        public int getTime(){
            Calendar calendar = null;
            int second = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                calendar = Calendar.getInstance();
                second = calendar.get(Calendar.SECOND);
            }

            return second;
        }
    };

}
