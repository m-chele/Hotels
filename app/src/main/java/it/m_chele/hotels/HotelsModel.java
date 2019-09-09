package it.m_chele.hotels;

import java.util.ArrayList;
import java.util.List;

class HotelsModel {

    public void get(OnFinishedListener onFinishedListener) {
        // TODO: fare chiamata di rete
        List datiFinti = new ArrayList();
        datiFinti.add(new Hotel("Nome Hotel 1"));
        datiFinti.add(new Hotel("Nome Hotel DUE"));
        datiFinti.add(new Hotel("Nome Hotel 33 E TRE"));
        boolean tuttoOK = false;

        if (tuttoOK) {
            onFinishedListener.onSuccess(datiFinti);
        } else {
            onFinishedListener.onError(new Exception("Errore di rete FINTO!"));
        }
    }


    // TODO: rxJava
    interface OnFinishedListener {

        void onSuccess(List<Hotel> hotelsList);

        void onError(Throwable t);
    }


}
