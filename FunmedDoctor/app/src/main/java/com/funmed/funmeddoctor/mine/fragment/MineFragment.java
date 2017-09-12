package com.funmed.funmeddoctor.mine.fragment;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.mine.activity.AboutUsActivity;
import com.funmed.funmeddoctor.mine.activity.MyDetectionOrderListActivity;
import com.funmed.funmeddoctor.mine.activity.MyResearchActivity;
import com.funmed.funmeddoctor.mine.activity.SettingActivity;
import com.funmed.funmeddoctor.mine.activity.UserInfoActivity;
import com.funmed.funmeddoctor.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseFragment;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by tony on 2017/7/18.
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.tv_mine_login_regist)
    TextView tvMineLoginRegist;
    @Bind(R.id.ll_mine_settings)
    LinearLayout llMineSettings;
    @Bind(R.id.ll_mine_myorder)
    LinearLayout llMineMyorder;
    @Bind(R.id.ll_mine_about_us)
    LinearLayout llMineAboutUs;
    @Bind(R.id.ll_mine_userinfo)
    LinearLayout llMineUserinfo;
    @Bind(R.id.headImage)
    CircleImageView headImage;
    @Bind(R.id.ll_mine_my_research)
    LinearLayout llMineMyResearch;
    @Bind(R.id.ll_contact_us)
    LinearLayout llContactUs;
    private final int REQUEST_CODE = 0x1001;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        tvMineLoginRegist.setText(User.getUser().getUsername());
        llMineMyorder.setVisibility(View.GONE);
    }


    @OnClick({R.id.ll_mine_userinfo, R.id.ll_mine_settings, R.id.ll_mine_myorder, R.id.ll_mine_about_us, R.id.ll_mine_my_research,R.id.ll_contact_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_mine_userinfo:
                startActivity(UserInfoActivity.class);
                break;
            case R.id.ll_mine_settings:
                startActivity(SettingActivity.class);
                break;
            case R.id.ll_mine_myorder:
                startActivity(MyDetectionOrderListActivity.class);
                break;
            case R.id.ll_mine_about_us:
                startActivity(AboutUsActivity.class);
                break;
            case R.id.ll_mine_my_research:
                startActivity(MyResearchActivity.class);
                break;
            case R.id.ll_contact_us:
                showCallDialog();
                break;
        }
    }

    private void showCallDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("电话联系我们？");
        builder.setMessage("021-54533696");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "02154533696"));//直接拨打电话
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void requestPermission() {
        //判断Android版本是否大于23
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE);

            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
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
            Toast.makeText(getContext(), "授权成功", Toast.LENGTH_SHORT).show();
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
