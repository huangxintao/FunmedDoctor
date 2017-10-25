package com.funmed.funmeddoctor.scientific.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.ScientificOrderTypeBean;
import com.funmed.funmeddoctor.scientific.adapter.ScientificOrderTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by tony on 2017/7/21.
 */

public class ScientificProjectOrderPlaceActivity extends BaseActivity {
    @Bind(R.id.iv_scientific_desc)
    ImageView ivScientificDesc;
    @Bind(R.id.rv_scientific_order_type)
    RecyclerView rvScientificOrderType;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    private ScientificOrderTypeAdapter adapter;
    private GridLayoutManager linearLayoutManager;
    private final int REQUEST_CODE = 0x1001;

    @Override
    public int getLayoutId() {
        return R.layout.activity_scientific_order_place;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        adapter = new ScientificOrderTypeAdapter(getList());
        linearLayoutManager = new GridLayoutManager(getApplicationContext(), 4);
    }

    @Override
    public void initView() {
        toolbarTitle.setText("科研检测");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        rvScientificOrderType.setLayoutManager(linearLayoutManager);
        rvScientificOrderType.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(NormalDetectionActivity.class);
                        break;
                    case 1:
                        startActivity(SeniorDetectionActivity.class);
                        break;
                    case 2:
                        showCallDialog();
                        break;
                }
            }
        });
    }

    private void showCallDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("电话联系我们？");
        builder.setMessage("021-54533696");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "02154533696"));//直接拨打电话
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                } else {
                    startActivity(dialIntent);
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


    private List<ScientificOrderTypeBean> getList() {
        List<ScientificOrderTypeBean> list = new ArrayList<ScientificOrderTypeBean>();
        ScientificOrderTypeBean bean = null;
        String[] names = {"常规检测", "协助SCI"};
        for (int i = 0; i < 2; i++) {
            bean = new ScientificOrderTypeBean();
            bean.setTypeName(names[i]);
            list.add(bean);
            bean = null;
        }
        return list;
    }

    private void requestPermission() {
        //判断Android版本是否大于23
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE);

            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            } else {
                callPhone();
            }
        } else {
            callPhone();
        }
    }

    /**
     * 注册权限申请回调
     *
     * @param requestCode  申请码
     * @param permissions  申请的权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE && PermissionChecker.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(mContext, "授权成功", Toast.LENGTH_SHORT).show();
            callPhone();
        }
    }

    /**
     * 拨号方法
     */
    private void callPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
    }

}
