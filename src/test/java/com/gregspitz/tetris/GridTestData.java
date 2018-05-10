package com.gregspitz.tetris;

public class GridTestData {

    public static final String EMPTY_GRID_DEFAULT_SIZE_STRING =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_SQUARE_AT_0_0 =
            "RR________\nRR________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_SQUARE_AT_1_0 =
            "_RR_______\n_RR_______\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_SQUARE_AT_8_0 =
            "________RR\n________RR\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_SQUARE_AT_0_1 =
            "__________\nRR________\nRR________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_SQUARE_AT_0_17 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\nRR________\nRR________\n__________\n";

    public static final String GRID_WITH_SQUARE_AT_0_18 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\nRR________\nRR________\n";

    public static final String GRID_WITH_STACKED_SQUARES_AT_0_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "RR________\nRR________\nRR________\nRR________\n";

    public static final String GRID_WITH_STRAIGHT_STACKED_ON_SQUARE_AT_0_14 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\nB_________\nB_________\n" +
                    "B_________\nB_________\nRR________\nRR________\n";

    public static final String GRID_WITH_RIGHT_STEP_STACKED_ON_SQUARE_AT_0_17 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "_GG_______\nGG________\nRR________\nRR________\n";

    public static final String GRID_WITH_LEFT_STEP_STACKED_ON_SQUARE_AT_0_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "MM________\n_MM_______\nRR________\nRR________\n";

    public static final String GRID_WITH_CENTER_STEP_STACKED_ON_SQUARE_AT_0_17 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "_Y________\nYYY_______\nRR________\nRR________\n";

    public static final String GRID_WITH_STRAIGHT_AT_0_0 =
            "B_________\nB_________\nB_________\nB_________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_STRAIGHT_AT_0_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    public static final String GRID_WITH_STRAIGHT_AT_5_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "_____B____\n_____B____\n_____B____\n_____B____\n";

    public static final String GRID_WITH_STRAIGHT_AT_0_16_AND_SQUARE_AT_1_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "BRR_______\nBRR_______\nB_________\nB_________\n";

    public static final String GRID_WITH_STRAIGHT_AT_5_16_AND_SQUARE_AT_3_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "___RRB____\n___RRB____\n_____B____\n_____B____\n";

    public static final String GRID_WITH_2_STRAIGHTS_STACKED_AT_0_12 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    public static final String GRID_WITH_3_STRAIGHTS_STACKED_AT_0_8 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    public static final String GRID_WITH_4_STRAIGHTS_STACKED_AT_0_4 =
            "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    public static final String GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0 =
            "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    public static final String GRID_WITH_RIGHT_STEP_AT_0_0 =
            "GG________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_LEFT_STEP_AT_0_0 =
            "MM________\n_MM_______\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    public static final String GRID_WITH_CENTER_STEP_AT_0_0 =
            "YYY_______\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";
}