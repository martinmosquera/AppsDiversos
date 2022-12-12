package com.semana08.todolist.helper;
import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;
    private RecyclerView recyclerView;
    GestureDetector mGestureDetector;
    private long tempo = 0;

    public RecyclerItemClickListener() {

    }

    public RecyclerItemClickListener(Context context,RecyclerView r, OnItemClickListener listener) {
        mListener = listener;
        recyclerView =r;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    public interface OnItemClickListener extends AdapterView.OnItemClickListener{


        public void onItemClick(View view, int position);

        public void onItemClick(AdapterView<?> a,View v,int i,long l);

        public void onItemLongClick(View childView, int childPosition);
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            long ini = e.getDownTime();
            long fin = e.getEventTime();
            if(fin-ini >= 250){
                mListener.onItemLongClick(childView,view.getChildPosition(childView));
            }else{
                mListener.onItemClick(childView, view.getChildPosition(childView));
            }
            return true;
        }
        return false;
    }

    @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}
}








