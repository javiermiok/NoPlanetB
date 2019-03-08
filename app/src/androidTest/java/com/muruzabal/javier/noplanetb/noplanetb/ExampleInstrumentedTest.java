package com.muruzabal.javier.noplanetb.noplanetb;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<BLogin> {

    private Button btnSignUp;

    public ExampleInstrumentedTest() {
        super(BLogin.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        BLogin actividad = getActivity();
        btnSignUp = actividad.findViewById(R.id.btnEntrarLogin);
    }

    public void testBtnLogin() {
        TouchUtils.tapView(this, btnSignUp);
    }
}
