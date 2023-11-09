package com.example.feedbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilterUserTypeAdapter extends RecyclerView.Adapter<FilterUserTypeAdapter.ViewHolder>
{
    ComplaintActivity complaintActivity;
    UserActivity userTypeActivity;
    Context context;
    private List<FilterUserTypeHelper> mFilterUserType;

    public FilterUserTypeAdapter(List<FilterUserTypeHelper> FilterCategorys, Context context2)
    {
        mFilterUserType = FilterCategorys;
        context = context2;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(FilterCategoryAdapter.ViewHolder holder, int position)
    {
        FilterUserTypeHelper FilterUserTypeHelper = mFilterUserType.get(position);

//        complaintActivity = new ComplaintActivity().getInstance();

        userTypeActivity = new UserActivity().getInstance();
        holder.tvCategoryName.setText(FilterUserTypeHelper.getUserType());

        holder.linearLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {

                    complaintActivity.Category = FilterUserTypeHelper.UserType;
                    complaintActivity.LoadFeedback();
                    complaintActivity.getDialog().dismiss();


                }
                catch (Exception err)
                {
                    holder.tvCategoryName.setText(err.getMessage());
                }
            }
        });
    }

    @Override
    public void onViewAttachedToWindow(@NonNull FilterUserTypeAdapter.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public int getItemCount() {
        return mFilterUserType.size();
    }

    @Override
    public FilterUserTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.filter_category_item_layout, parent, false);

        FilterUserTypeAdapter.ViewHolder viewHolder = new FilterUserTypeAdapter.ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvCategoryName;

        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
        }
    }
}
