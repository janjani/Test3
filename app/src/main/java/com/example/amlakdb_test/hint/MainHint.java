package com.example.amlakdb_test.hint;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.amlakdb_test.utils.Tools;
import com.example.amlakdb_test.utils.ViewAnimation;
import com.example.amlakdb_test.utils.ViewAnimation.AnimListener;
import com.example.amlakdb_test.R;

public class MainHint extends AppCompatActivity {
    private Button bt_hide_input;
    private Button bt_hide_input_1;
    private Button bt_hide_input_2;
    private Button bt_hide_text;
    /* access modifiers changed from: private */
    public ImageButton bt_toggle_input;
    /* access modifiers changed from: private */
    public ImageButton bt_toggle_input_1;
    /* access modifiers changed from: private */
    public ImageButton bt_toggle_input_2;
    /* access modifiers changed from: private */
    public ImageButton bt_toggle_text;
    /* access modifiers changed from: private */
    public View lyt_expand_input;
    /* access modifiers changed from: private */
    public View lyt_expand_input_1;
    /* access modifiers changed from: private */
    public View lyt_expand_input_2;
    /* access modifiers changed from: private */
    public View lyt_expand_text;
    /* access modifiers changed from: private */
    public NestedScrollView nested_scroll_view;
    private View parent_view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_hint);
        this.parent_view = findViewById(R.id.content);
     initComponent();
    }

    private void initComponent() {
        this.bt_toggle_text = (ImageButton) findViewById(R.id.bt_toggle_text);
        this.bt_hide_text = (Button) findViewById(R.id.bt_hide_text);
        this.lyt_expand_text = findViewById(R.id.lyt_expand_text);
        this.lyt_expand_text.setVisibility(View.GONE);
        this.bt_toggle_text.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionText(mainHint.bt_toggle_text);
            }
        });
        this.bt_hide_text.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionText(mainHint.bt_toggle_text);
            }
        });
        this.bt_toggle_input = (ImageButton) findViewById(R.id.bt_toggle_input);
        this.bt_hide_input = (Button) findViewById(R.id.bt_hide_input);
        this.lyt_expand_input = findViewById(R.id.lyt_expand_input);
        this.lyt_expand_input.setVisibility(View.GONE);
        this.bt_toggle_input.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionInput(mainHint.bt_toggle_input);
            }
        });
        this.bt_hide_input.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionInput(mainHint.bt_toggle_input);
            }
        });
        this.bt_toggle_input_1 = (ImageButton) findViewById(R.id.bt_toggle_input1);
        this.bt_hide_input_1 = (Button) findViewById(R.id.bt_hide_input1);
        this.lyt_expand_input_1 = findViewById(R.id.lyt_expand_input1);
        this.lyt_expand_input_1.setVisibility(View.GONE);
        this.bt_toggle_input_1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionInput1(mainHint.bt_toggle_input_1);
            }
        });
        this.bt_hide_input_1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionInput1(mainHint.bt_toggle_input_1);
            }
        });
        this.bt_toggle_input_2 = (ImageButton) findViewById(R.id.bt_toggle_input2);
        this.bt_hide_input_2 = (Button) findViewById(R.id.bt_hide_input2);
        this.lyt_expand_input_2 = findViewById(R.id.lyt_expand_input2);
        this.lyt_expand_input_2.setVisibility(View.GONE);
        this.bt_toggle_input_2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionInput2(mainHint.bt_toggle_input_2);
            }
        });
        this.bt_hide_input_2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainHint mainHint = MainHint.this;
                mainHint.toggleSectionInput2(mainHint.bt_toggle_input_2);
            }
        });
        this.nested_scroll_view = (NestedScrollView) findViewById(R.id.nested_scroll_view);
    }

    /* access modifiers changed from: private */
    public void toggleSectionText(View view) {
        if (toggleArrow(view)) {
            ViewAnimation.expand(this.lyt_expand_text, new AnimListener() {
                public void onFinish() {
                    Tools.nestedScrollTo(MainHint.this.nested_scroll_view, MainHint.this.lyt_expand_text);
                }
            });
        } else {
            ViewAnimation.collapse(this.lyt_expand_text);
        }
    }

    /* access modifiers changed from: private */
    public void toggleSectionInput(View view) {
        if (toggleArrow(view)) {
            ViewAnimation.expand(this.lyt_expand_input, new AnimListener() {
                public void onFinish() {
                    Tools.nestedScrollTo(MainHint.this.nested_scroll_view, MainHint.this.lyt_expand_input);
                }
            });
        } else {
            ViewAnimation.collapse(this.lyt_expand_input);
        }
    }

    /* access modifiers changed from: private */
    public void toggleSectionInput1(View v) {
        if (toggleArrow(v)) {
            ViewAnimation.expand(this.lyt_expand_input_1, new AnimListener() {
                public void onFinish() {
                    Tools.nestedScrollTo(MainHint.this.nested_scroll_view, MainHint.this.lyt_expand_input_1);
                }
            });
        } else {
            ViewAnimation.collapse(this.lyt_expand_input_1);
        }
    }

    /* access modifiers changed from: private */
    public void toggleSectionInput2(View v) {
        if (toggleArrow(v)) {
            ViewAnimation.expand(this.lyt_expand_input_2, new AnimListener() {
                public void onFinish() {
                    Tools.nestedScrollTo(MainHint.this.nested_scroll_view, MainHint.this.lyt_expand_input_2);
                }
            });
        } else {
            ViewAnimation.collapse(this.lyt_expand_input_2);
        }
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0.0f) {
            view.animate().setDuration(200).rotation(180.0f);
            return true;
        }
        view.animate().setDuration(200).rotation(0.0f);
        return false;
    }
}

