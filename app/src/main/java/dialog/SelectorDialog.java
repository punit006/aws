package dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.xordroid.androidwebservice.R;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public abstract class SelectorDialog extends Dialog implements View.OnClickListener{

    private TextView gallery,camera;

    protected SelectorDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_selector);
        gallery = (TextView) findViewById(R.id.tv_gallery);
        camera = (TextView) findViewById(R.id.tv_camera);
        gallery.setOnClickListener(this);
        camera.setOnClickListener(this);
    }
}