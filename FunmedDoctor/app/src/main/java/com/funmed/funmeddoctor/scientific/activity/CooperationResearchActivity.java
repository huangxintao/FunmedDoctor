package com.funmed.funmeddoctor.scientific.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.DataResponse;
import com.funmed.funmeddoctor.bean.FormResponseData;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/8/7.
 */

public class CooperationResearchActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_initiator)
    TextView etInitiator;
    @Bind(R.id.et_phone)
    TextView etPhone;
    @Bind(R.id.et_email)
    TextView etEmail;
    @Bind(R.id.et_disease_name)
    TextView etDiseaseName;
    @Bind(R.id.et_profile)
    TextView etProfile;
    @Bind(R.id.et_research_fund)
    TextView etResearchFund;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.et_end_time)
    EditText etEndTime;
    @Bind(R.id.scrollview)
    ScrollView scrollview;
    @Bind(R.id.input_corver)
    FrameLayout inputCorver;
    @Bind(R.id.spinner_seek_help)
    Spinner spinnerSeekHelp;
    @Bind(R.id.ll_profile)
    LinearLayout llProfile;
    @Bind(R.id.et_sample_name)
    EditText etSampleName;
    @Bind(R.id.et_sample_number)
    EditText etSampleNumber;
    @Bind(R.id.et_detection_method)
    EditText etDetectionMethod;
    @Bind(R.id.ll_find_sample)
    LinearLayout llFindSample;
    @Bind(R.id.et_special_requirement)
    EditText etSpecialRequirement;
    @Bind(R.id.rb_yes)
    RadioButton rbYes;
    @Bind(R.id.rb_no)
    RadioButton rbNo;
    @Bind(R.id.rb_is_checked)
    RadioButton rbIsChecked;
    @Bind(R.id.rb_not_checked)
    RadioButton rbNotChecked;
    private ApiService service;
    private Map<String, String> params = new HashMap<String, String>();
    private String[] items = {"找样本", "找合作伙伴","找资金","找数据"};
    private int help_tpye = 1;
    private String isUrgent = "否";
    private String isChecked = "否";

    @Override
    public int getLayoutId() {
        return R.layout.activity_cooperation_research_new;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImpl.getInstance().createService(ApiService.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initView() {
        toolbarTitle.setText("发起互助式研究");
        setSupportActionBar(toolbar);
        toolbar.setFitsSystemWindows(false);
        etInitiator.setText(User.getUser().getUsername());
        etPhone.setText(User.getUser().getMobile());
        etEmail.setText(User.getUser().getEmail());
        rbNotChecked.setChecked(true);
        rbNo.setChecked(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            toolbar.setPadding(0, getStatusBarHeight(this), 0, 0);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        controlKeyboardLayout(scrollview, CooperationResearchActivity.this);
        scrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (i1 < i3) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(etDiseaseName.getWindowToken(), 0);
                }
            }
        });

        rbYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isUrgent = "是";
                } else {
                    isUrgent = "否";
                }
            }
        });
        rbNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isUrgent = "否";
                } else {
                    isUrgent = "是";
                }
            }
        });

        rbIsChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isChecked = "是";
                } else {
                    isChecked = "否";
                }
            }
        });
        rbNotChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isChecked = "否";
                } else {
                    isChecked = "是";
                }
            }
        });

        spinnerSeekHelp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items));
        spinnerSeekHelp.setPadding(5, 10, 5, 10);
        spinnerSeekHelp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
//                Toast.makeText(mContext, items[pos], Toast.LENGTH_SHORT).show();
                if (pos == 0) {
                    llFindSample.setVisibility(View.VISIBLE);
                    llProfile.setVisibility(View.GONE);
                    help_tpye = 1;//找样本
                } else {
                    llFindSample.setVisibility(View.GONE);
                    llProfile.setVisibility(View.VISIBLE);
                    help_tpye = 2;//找合作伙伴
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void controlKeyboardLayout(final ScrollView root, final Activity context) {
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                root.getWindowVisibleDisplayFrame(rect);
                int rootInvisibleHeight = root.getRootView().getHeight() - rect.bottom;
                //若不可视区域高度大于100，则键盘显示
                if (rootInvisibleHeight > 100) {
                    int[] location = new int[2];
                    View focus = context.getCurrentFocus();
                    if (focus != null) {
                        focus.getLocationInWindow(location);
                        int scrollHeight = (location[1] + focus.getHeight()) - rect.bottom;
                        if (rect.bottom < location[1] + focus.getHeight()) {
                            ViewGroup.LayoutParams layoutParams = inputCorver.getLayoutParams();
                            layoutParams.height = rootInvisibleHeight;
                            inputCorver.setLayoutParams(layoutParams);
                        }
                    }
                } else {
                    //键盘隐藏
                    ViewGroup.LayoutParams layoutParams = inputCorver.getLayoutParams();
                    layoutParams.height = 0;
                    inputCorver.setLayoutParams(layoutParams);
                }
            }
        });
    }

    @OnClick(R.id.btn_commit)
    public void onViewClicked() {
        params.clear();
            params.put("initiator", etInitiator.getText().toString());
            params.put("userid", User.getUser().getUserid());
            params.put("mobile", etPhone.getText().toString());
            params.put("email", etEmail.getText().toString());
            if (help_tpye == 1) {
                if (checkNull1()) {
                    params.put("formtype", help_tpye + "");
                    params.put("help_content", etProfile.getText().toString());
                    params.put("sample_name", etSampleName.getText().toString());
                    params.put("sample_size", etSampleNumber.getText().toString());
                    params.put("inspection_methods_and_indexes", etDetectionMethod.getText().toString());
                    params.put("special_requirements", etSpecialRequirement.getText().toString());

                    params.put("diseaser_name", etDiseaseName.getText().toString());
                    params.put("profile", etProfile.getText().toString());
                    params.put("research_fund", etResearchFund.getText().toString());
                } else {
                    return;
                }
            } else {
                if (checkNull2()) {
                    params.put("formtype", help_tpye + "");
                    params.put("cycle", etEndTime.getText().toString());
                    params.put("urgent", isUrgent);

                    params.put("diseaser_name", etSampleName.getText().toString());
                    params.put("profile", etProfile.getText().toString());
                    params.put("research_fund", etDetectionMethod.getText().toString());
                }else {
                    return;
                }
            }
            Call<DataResponse<FormResponseData>> call = service.addResearchForm(params);
            call.enqueue(new Callback<DataResponse<FormResponseData>>() {
                @Override
                public void onResponse(Call<DataResponse<FormResponseData>> call, Response<DataResponse<FormResponseData>> response) {
                    if (response != null && response.body().getCode() == 0) {
                        Toast.makeText(CooperationResearchActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        startActivity(CommitSuccessActivity.class);
                    } else {
                        Toast.makeText(CooperationResearchActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<DataResponse<FormResponseData>> call, Throwable t) {
                    Toast.makeText(CooperationResearchActivity.this, call.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    private boolean checkNull1() {
        boolean checked = false;
        if (TextUtils.isEmpty(etInitiator.getText())) {
            Toast.makeText(mContext, "请输入发起人姓名", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etPhone.getText())) {
            Toast.makeText(mContext, "请输入电话号码", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etEmail.getText())) {
            Toast.makeText(mContext, "请输入邮箱", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etDiseaseName.getText())) {
            Toast.makeText(mContext, "请输入研究题目", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etProfile.getText())){
            Toast.makeText(mContext, "请输入求助内容", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etSampleName.getText())) {
            Toast.makeText(mContext, "请输入样本名称", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etSampleNumber.getText())) {
            Toast.makeText(mContext, "请输入样本数量", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etDetectionMethod.getText())){
            Toast.makeText(mContext, "请输入检测方法", Toast.LENGTH_SHORT).show();
        }else {
            checked = true;
        }
        return checked;
    }

    private boolean checkNull2() {
        boolean checked = false;
        if (TextUtils.isEmpty(etInitiator.getText())) {
            Toast.makeText(mContext, "请输入发起人姓名", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etPhone.getText())) {
            Toast.makeText(mContext, "请输入电话号码", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etEmail.getText())) {
            Toast.makeText(mContext, "请输入邮箱", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etDiseaseName.getText())) {
            Toast.makeText(mContext, "请输入研究题目", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etProfile.getText())) {
            Toast.makeText(mContext, "请输入求助内容", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etResearchFund.getText())) {
            Toast.makeText(mContext, "请输入研究报酬", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etEndTime.getText())){
            Toast.makeText(mContext, "请输入截止时间", Toast.LENGTH_SHORT).show();
        }else {
            checked = true;
        }
        return checked;
    }

    //获取状态栏高度
    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = dip2px(context, 25);
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    //根据手机的分辨率从 dp 的单位 转成为 px(像素)
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private boolean isKeyboardShown(View rootView) {
        final int softKeyboardHeight = 100;
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - r.bottom;
        return heightDiff > softKeyboardHeight * dm.density;
    }
}
