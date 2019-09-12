package it.m_chele.hotels;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

class ImagesAdapter extends PagerAdapter {

    private Context context;
    private List<String> imagesUrl;

    public ImagesAdapter(Context context, List imagesUrl) {
        this.context = context;
        this.imagesUrl = imagesUrl;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Picasso.get()
                .load(imagesUrl.get(position))
                .error(R.drawable.image_problem)
                .into(imageView);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public int getCount() {
        return imagesUrl.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
