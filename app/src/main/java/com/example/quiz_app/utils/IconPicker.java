package com.example.quiz_app.utils;

import com.example.quiz_app.R;

public class IconPicker {
    public static int[] draws = {
            R.drawable.ic_iconfinder_4213589_calculate_calculator_doodle_education_line_icon,
            R.drawable.ic_iconfinder_bell,
            R.drawable.ic_iconfinder_board_icon
    };

    static int currentIcon = 0;
    public static int getIcon(){

        currentIcon = (currentIcon+1) % draws.length;
        return draws[currentIcon];
    }
}

