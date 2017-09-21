package de.android.rxjavarxandroidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    public static final String MY_OBSERVER = "MY_OBSERVER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> observable = Observable.just("Hello");
        Observer<String> observer1 = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d(MY_OBSERVER, "the result from first");
            }
        };

        Action1<String> observer = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(MY_OBSERVER, "the result from second");
            }
        };
        Subscription sub1 = observable.subscribe(observer1);
        Subscription sub2 = observable.subscribe(observer);

        Observable<String> arrayObservable = Observable.from(new String[]{"Hello",
        "Gracias",
        "Bonjurno",
        "Goodbye",
        "Salam",
        "Shalom"});
    }
}
