package listener;

import android.view.View;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public interface RecyclerClick_Listener {

    /**
     * Interface for Recycler View Click listener
     **/

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}

