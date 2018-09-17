package com.example.jinhui.androiddemo.feature.shopcar.rvshopcar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.bean.ShopCartBean;

import java.util.List; /**
 * Created by jh on 2018/9/17.
 * Email: 1004260403@qq.com
 */
public class ShopCartAdapter  extends RecyclerView.Adapter<ShopCartAdapter.MyViewHolder> {

    private Context context;
    private List<ShopCartBean.CartlistBean> data;
    private View headerView;

    private OnDeleteClickListener mOnDeleteClickListener;
    private OnEditClickListener mOnEditClickListener;
    private OnRefreshListener mOnRefreshListener;

    public ShopCartAdapter(Context context, List<ShopCartBean.CartlistBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopCartAdapter.MyViewHolder(LayoutInflater.from(context)
                        .inflate(R.layout.item_shopcart, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(data.get(position).getDefaultPic())
                .into(holder.ivShopCartClothPic);
        holder.tvShopCartClothColor.setText("颜色：" + data.get(position).getColor());
        holder.tvShopCartClothSize.setText("尺寸：" + data.get(position).getSize());
        holder.tvShopCartClothName.setText(data.get(position).getProductName());
        holder.tvShopCartShopName.setText(data.get(position).getShopName());
        holder.tvShopCartClothPrice.setText("¥" + data.get(position).getPrice());
        holder.etShopCartClothNum.setText(data.get(position).getCount() + "");

        if (position > 0) {
            if (data.get(position).getShopId() == data.get(position - 1).getShopId()) {
                holder.llShopCartHeader.setVisibility(View.GONE);
            } else {
                holder.llShopCartHeader.setVisibility(View.VISIBLE);
            }
        } else {
            holder.llShopCartHeader.setVisibility(View.VISIBLE);
        }

        // 设置事件
        if (mOnRefreshListener != null) {
            boolean isSelect = false;
            for (int i = 0; i < data.size(); i++) {
                if (!data.get(i).getIsSelect()) {
                    isSelect = false;
                    break;
                } else {
                    isSelect = true;
                }
            }
            mOnRefreshListener.onRefresh(isSelect);
        }

        holder.ivShopCartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).getCount() > 1) {
                    int count = data.get(position).getCount() - 1;
                    if (mOnEditClickListener != null) {
                        mOnEditClickListener.onEditClick(position, data.get(position).getId(), count);
                    }
                    data.get(position).setCount(count);
                    notifyDataSetChanged();
                }
            }
        });

        holder.ivShopCartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = data.get(position).getCount() + 1;
                if (mOnEditClickListener != null) {
                    mOnEditClickListener.onEditClick(position, data.get(position).getId(), count);
                }
                data.get(position).setCount(count);
                notifyDataSetChanged();
            }
        });

        if (data.get(position).getIsSelect()) {
            holder.ivShopCartClothSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        } else {
            holder.ivShopCartClothSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        if (data.get(position).getIsShopSelect()) {
            holder.ivShopCartShopSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        } else {
            holder.ivShopCartShopSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        holder.ivShopCartClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v, position);
            }
        });

        holder.ivShopCartClothSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setSelect(!data.get(position).getIsSelect());
                //通过循环找出不同商铺的第一个商品的位置
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getIsFirst() == 1) {
                        //遍历去找出同一家商铺的所有商品的勾选情况
                        for (int j = 0; j < data.size(); j++) {
                            //如果是同一家商铺的商品，并且其中一个商品是未选中，那么商铺的全选勾选取消
                            if (data.get(j).getShopId() == data.get(i).getShopId() && !data.get(j).getIsSelect()) {
                                data.get(i).setShopSelect(false);
                                break;
                            } else {
                                //如果是同一家商铺的商品，并且所有商品是选中，那么商铺的选中全选勾选
                                data.get(i).setShopSelect(true);
                            }
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });

        holder.ivShopCartShopSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).getIsFirst() == 1) {
                    data.get(position).setShopSelect(!data.get(position).getIsShopSelect());
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).getShopId() == data.get(position).getShopId()) {
                            data.get(i).setSelect(data.get(position).getIsShopSelect());
                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });

    }

    private void showDialog(final View view, final int position) {
        //调用删除某个规格商品的接口
        if (mOnDeleteClickListener != null) {
            mOnDeleteClickListener.onDeleteClick(view, position, data.get(position).getId());
        }
        data.remove(position);
        //重新排序，标记所有商品不同商铺第一个的商品位置
        RvShopCarActivity.isSelectFirst(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        int count = (data == null ? 0 : data.size());
        if (headerView != null) {
            count++;
        }
        return count;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivShopCartShopSel;
        private TextView tvShopCartShopName;
        private TextView tvShopCartClothName;
        private TextView tvShopCartClothPrice;
        private TextView etShopCartClothNum;
        private TextView tvShopCartClothColor;
        private TextView tvShopCartClothSize;
        private ImageView ivShopCartClothSel;
        private ImageView ivShopCartClothMinus;
        private ImageView ivShopCartClothAdd;
        private ImageView ivShopCartClothDelete;
        private ImageView ivShopCartClothPic;
        private LinearLayout llShopCartHeader;

        public MyViewHolder(View view) {
            super(view);

            llShopCartHeader = (LinearLayout) view.findViewById(R.id.ll_shopcart_header);
            ivShopCartShopSel = (ImageView) view.findViewById(R.id.iv_item_shopcart_shopselect);
            tvShopCartShopName = (TextView) view.findViewById(R.id.tv_item_shopcart_shopname);
            tvShopCartClothName = (TextView) view.findViewById(R.id.tv_item_shopcart_clothname);
            tvShopCartClothPrice = (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_price);
            etShopCartClothNum = (TextView) view.findViewById(R.id.et_item_shopcart_cloth_num);
            tvShopCartClothColor = (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_color);
            tvShopCartClothSize = (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_size);
            ivShopCartClothSel = (ImageView) view.findViewById(R.id.tv_item_shopcart_clothselect);
            ivShopCartClothMinus = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_minus);
            ivShopCartClothAdd = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_add);
            ivShopCartClothPic = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_pic);
            ivShopCartClothDelete = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_delete);

        }
    }


    // 接口回调
    public interface OnDeleteClickListener {
        void onDeleteClick(View view, int position, int cartid);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener mOnDeleteClickListener) {
        this.mOnDeleteClickListener = mOnDeleteClickListener;
    }

    public interface OnEditClickListener {
        void onEditClick(int position, int cartid, int count);
    }

    public void setOnEditClickListener(OnEditClickListener mOnEditClickListener) {
        this.mOnEditClickListener = mOnEditClickListener;
    }

    public interface OnRefreshListener {
        void onRefresh(boolean isSelect);
    }

    public void setOnRefreshListener(OnRefreshListener mOnRefreshListener) {
        this.mOnRefreshListener = mOnRefreshListener;
    }
}
