package com.example.myui;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 123 on 2017/7/16.
 */

public class IdentityAdapter extends ArrayAdapter<IdentityMessage> {
    private int resourceId;

    public IdentityAdapter(@NonNull Context context, @LayoutRes int textViewResourceId, @NonNull List<IdentityMessage> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        IdentityMessage identityMessage = getItem(position); //获取当前的IdentityMessage 的实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.IdentityImage = (ImageView) view.findViewById(
                    R.id.identity_image);
            viewHolder.IdentityName = (TextView) view.findViewById
                    (R.id.identity_name);
            view.setTag(viewHolder); //将ViewHolder存储的到view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.IdentityName.setText(identityMessage.getName());
        viewHolder.IdentityImage.setImageResource(identityMessage.getImageId());
        return view;
    }

    class ViewHolder {

        ImageView IdentityImage;

        TextView IdentityName;
    }
}
