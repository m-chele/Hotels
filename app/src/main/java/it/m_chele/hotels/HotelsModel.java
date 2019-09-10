package it.m_chele.hotels;

import java.util.ArrayList;
import java.util.List;

class HotelsModel {

    public void get(OnFinishedListener onFinishedListener) {
        // TODO: fare chiamata di rete
        List datiFinti = new ArrayList();
        datiFinti.add(new Hotel("Park Plaza London Waterloo"));
        datiFinti.add(new Hotel("Belgrave House Hotel"));
        datiFinti.add(new Hotel("Absolute Pleasure Yacht"));
        datiFinti.add(new Hotel("una riga"));
        datiFinti.add(new Hotel("The Z Hotel Piccadilly"));
        datiFinti.add(new Hotel("Holiday Inn Express"));
        datiFinti.add(new Hotel("Crowne Plaza LONDON - KINGS CROSS"));
        boolean tuttoOK = true;
//        boolean tuttoOK = false;

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
