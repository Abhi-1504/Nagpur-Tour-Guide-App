package com.yoyi.android.naranginagpur;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/***
 * {@link LocationAdapter} ia an {@link FragmentPagerAdapter} that can provide the tab layout for each list item
 * based on the data source, which is a list of {@link Location} objects.
 */

public class LocationAdapter extends FragmentPagerAdapter {

    // For getting the tab label from resources
    private Context mContext;

    /***
     * LocationAdapter Constructor
     * @param context gets the calling Fragment context
     * @param fm Current Fragment's FragmentManager object
     */
    public LocationAdapter(Context context, FragmentManager fm) {

        // Calling the super class Fragment Pager Adapter constructor
        super(fm);

        mContext = context;
    }

    /***
     * The method returns the Fragment object depending on the position
     * @param position stores the current position of the tab
     * @return Fragment object
     */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 1:
                return new RestrauntsFragment();
            case 2:
                return new MallsFragment();
            case 3:
                return new MarketsFragment();
            default:
                return new TouristAttractionsFragment();

        }
    }

    /***
     * Returns the total count of Tabs present in the layout
     * @return
     */
    @Override
    public int getCount() {
        return 4;
    }

    /***
     * Returns the tab label ID depending upon the position of the tab
     * @param position stores the current position of the tab
     * @return tab label's string ID from resources
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 1:
                return mContext.getString(R.string.restaurants);
            case 2:
                return mContext.getString(R.string.malls);
            case 3:
                return mContext.getString(R.string.markets);
            default:
                return mContext.getString(R.string.tourist_attractions);
        }
    }
}
