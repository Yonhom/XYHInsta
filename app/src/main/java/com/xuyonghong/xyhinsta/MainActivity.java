package com.xuyonghong.xyhinsta;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.xuyonghong.xyhinsta.adapter.InstaFeedAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.main_toolbar)
    Toolbar mMainToolbar;

    @BindView(R.id.main_drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.feed_main_view)
    RecyclerView mFeedMainView;

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
        actionBarFromToolBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        actionBarFromToolBar.setDisplayHomeAsUpEnabled(true);
        actionBarFromToolBar.setDisplayShowTitleEnabled(false);

        // call the metod to enable the burger button to open/close the drawer
        mDrawerLayout.addDrawerListener(new ActionBarDrawerToggle(this, mDrawerLayout, mMainToolbar, 0, 0));

        //set the main content
        mFeedMainView.setAdapter(new InstaFeedAdapter(this));
        mFeedMainView.setLayoutManager(new LinearLayoutManager(this));

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
