package com.radioesieaclub.recapp.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.radioesieaclub.recapp.Model.RestArticleReponse;
import com.radioesieaclub.recapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{
    private List<RestArticleReponse> values;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtView;
        public ImageView imgView;
        public View layout;
        public ViewHolder(View v) {
            super(v);
            this.layout = v;
            this.txtView = v.findViewById(R.id.txtView);
            this.imgView = v.findViewById(R.id.imgView);
        }
    }

    public ArticleAdapter(List<RestArticleReponse> resp) {
        values = resp;
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //v.setOnClickListener(this.listener);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        RestArticleReponse currentArticle = values.get(position);
        final String name = currentArticle.getTitre();
        holder.txtView.setText(name);

        Picasso
                .get()
                .load("http://radioesieaclub.com/media/" + currentArticle.getImage())
                .resize(0,50)
                .into(holder.imgView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
