package com.example.testv2.adapter;

import com.example.testv2.ui.TestV1;
import com.example.testv2.ui.TestV2;
import com.example.testv2.ui.TestV3;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdaptor extends FragmentStatePagerAdapter {
    int tabNum;
    public PagerAdaptor(FragmentManager fm, int tabNum) {
        super(fm);
        this.tabNum=tabNum;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=new TestV1();
        System.out.println(position + "testing ");
        switch (position){
            case 0:
                fragment= new TestV1();
                break;
            case 1:
                fragment= new TestV2();
                break;
            case 2:
                fragment= new TestV3();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
