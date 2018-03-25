package com.example.interviewpractice.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.interviewpractice.R;


/**
 * Created by 鱼握拳 on 2017/9/19.
 */

public class LinedEditText extends RelativeLayout {

    public static final int MODE_REMAINING = 1;
    public static final int MODE_PERCENTAGE = 2;
    private EditText etContent;
    private TextView tvNum;
    private int mMode;
    private int maxLength = 100;
    private String mHintText;
    private float editTextSize = 15;
    private float countTextSize = 10;
    private int editTextColor = Color.BLACK;


    public Editable getText() {
        return (Editable) etContent.getText();
    }
    public void setSelection(int start, int stop) {
        Selection.setSelection(getText(), start, stop);
    }
    public void selectAll() {
        Selection.selectAll(getText());
    }
    public void extendSelection(int index) {
        Selection.extendSelection(getText(), index);
    }



    public LinedEditText(Context context) {
        this(context, null);
    }

    public LinedEditText(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }




    public LinedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CountEditText);
        maxLength = array.getInt(R.styleable.CountEditText_ce_maxLength, maxLength);
        if (array.hasValue(R.styleable.CountEditText_ce_countMode)) {
            mMode = array.getInt(R.styleable.CountEditText_ce_countMode, MODE_PERCENTAGE);
        }
        mHintText = array.getString(R.styleable.CountEditText_ce_hint);
        editTextSize = array.getDimension(R.styleable.CountEditText_ce_edit_text_size, editTextSize);
        editTextColor = array.getColor(R.styleable.CountEditText_ce_edit_text_color, editTextColor);
        countTextSize = array.getDimension(R.styleable.CountEditText_ce_count_text_size, countTextSize);
        array.recycle();

        LayoutInflater.from(context).inflate(R.layout.anfq_num_edittext, this, true);
        etContent = (EditText) findViewById(R.id.etContent);
        tvNum = (TextView) findViewById(R.id.tvNum);

        if (mMode == MODE_REMAINING) {
            tvNum.setText(String.valueOf(maxLength));
        } else if (mMode == MODE_PERCENTAGE) {
            tvNum.setText(0 + "/" + maxLength);
        }
        etContent.setHint(mHintText);
        etContent.setTextSize(editTextSize);
        etContent.setTextColor(editTextColor);
        InputFilter[] filters = {new InputFilter.LengthFilter(maxLength)};
        etContent.setFilters(filters);
        etContent.addTextChangedListener(mTextWatcher);
        tvNum.setTextSize(countTextSize);
    }

    // 输入监听
    private TextWatcher mTextWatcher = new TextWatcher() {
        private int editStart;
        private int editEnd;

        public void afterTextChanged(Editable s) {
            editStart = etContent.getSelectionStart();
            editEnd = etContent.getSelectionEnd();
            etContent.removeTextChangedListener(mTextWatcher);
            while (calculateLength(s.toString()) > maxLength) {
                s.delete(editStart - 1, editEnd);
                editStart--;
                editEnd--;
            }
            // 恢复监听器
            etContent.addTextChangedListener(mTextWatcher);
            setLeftCount();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };


    private void setLeftCount() {
        //  获取用户输入内容字数
        long inputCount = calculateLength(etContent.getText().toString());
        if (mMode == MODE_REMAINING) {
            tvNum.setText(String.valueOf(maxLength - inputCount));
        } else if (mMode == MODE_PERCENTAGE) {
            tvNum.setText(maxLength - (maxLength - inputCount) + "/" + maxLength);
        }
    }

    public static long calculateLength(CharSequence cs) {
        double len = 0;
        for (int i = 0; i < cs.length(); i++) {
            int tmp = (int) cs.charAt(i);
            if (tmp > 0 && tmp < 127) {
                len += 1;
            } else {
                len++;
            }
        }
        return Math.round(len);
    }
}
