package com.lennydennis.dukayangu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;

public class ViewPagerAdapter extends PagerAdapter {

    private List<Product> products;
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.most_viewed_product, container, false);

        ImageView mostViewedImage;
        TextView mostViewedName;
        TextView mostViewedPrice;

        mostViewedImage = view.findViewById(R.id.most_viewed_image);
        mostViewedName = view.findViewById(R.id.most_viewed_name);
        mostViewedPrice = view.findViewById(R.id.most_viewed_price);

        Glide.with(context)
                .asBitmap()
                .load(products.get(position).getImage())
                .into(mostViewedImage);
        mostViewedName.setText(products.get(position).getName());
        String salesPrice = Double.toString(products.get(position).getSalePrice());
        mostViewedPrice.setText(salesPrice);

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
