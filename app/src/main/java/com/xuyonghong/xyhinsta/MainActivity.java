package com.xuyonghong.xyhinsta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.xuyonghong.xyhinsta.fragment.FeedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.main_toolbar)
    Toolbar mMainToolbar;

    @BindView(R.id.main_drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.main_content_container)
    FrameLayout mMainContentContainer;

    private ActionBar actionBarFromToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        // wire the toolbar to the action bar in traditional window,
        // also allow us to manipulate the toolbar as a actionbar
        setSupportActionBar(mMainToolbar);
        // the action bar the system provide for us using the toolbar we provided
        actionBarFromToolBar = getSupportActionBar();

        // set the burger icon on the toolbar for toggling the drawer
        mMainToolbar.setNavigationIcon(R.drawable.ic_menu_white);
        mMainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mDrawerLayout.isDrawerOpen(R.id.main_drawer))
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                else
                    mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        mMainToolbar.setNavigationContentDescription("navigation button for opening and closing drawer");


        // cause we already designated a logo, so we disable the default toolbar title
        actionBarFromToolBar.setDisplayShowTitleEnabled(false);

        //set the main content
        FeedFragment feedFragment = new FeedFragment();
        String feedFragmentTag = FeedFragment.class.getSimpleName();
        loadFramgent(feedFragment, feedFragmentTag);

    }

    /**
     * load a fragment with tag
     * @param fragment
     * @param fragmentTag
     */
    private void loadFramgent(Fragment fragment, String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content_container, fragment, fragmentTag);
        transaction.addToBackStack(fragmentTag);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        // inflating the main menu layout into the menu provided by the system

        menuInflater.inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_inbox).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
