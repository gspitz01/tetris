package com.gregspitz.tetris;

class GridTestData {

    static final String EMPTY_GRID_DEFAULT_SIZE_STRING =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_SQUARE_AT_0_0 =
            "RR________\nRR________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_SQUARE_AT_1_0 =
            "_RR_______\n_RR_______\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_SQUARE_AT_8_0 =
            "________RR\n________RR\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_SQUARE_AT_0_1 =
            "__________\nRR________\nRR________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_SQUARE_AT_0_17 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\nRR________\nRR________\n__________\n";

    static final String GRID_WITH_SQUARE_AT_0_18 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\nRR________\nRR________\n";

    static final String GRID_WITH_STACKED_SQUARES_AT_0_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "RR________\nRR________\nRR________\nRR________\n";

    static final String GRID_WITH_STRAIGHT_STACKED_ON_SQUARE_AT_0_14 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\nB_________\nB_________\n" +
                    "B_________\nB_________\nRR________\nRR________\n";

    static final String GRID_WITH_RIGHT_STEP_STACKED_ON_SQUARE_AT_0_17 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "_GG_______\nGG________\nRR________\nRR________\n";

    static final String GRID_WITH_LEFT_STEP_STACKED_ON_SQUARE_AT_0_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "MM________\n_MM_______\nRR________\nRR________\n";

    static final String GRID_WITH_CENTER_STEP_STACKED_ON_SQUARE_AT_0_17 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "_Y________\nYYY_______\nRR________\nRR________\n";

    static final String GRID_WITH_STRAIGHT_AT_0_0 =
            "B_________\nB_________\nB_________\nB_________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_STRAIGHT_AT_4_0 =
            "____B_____\n____B_____\n____B_____\n____B_____\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_STRAIGHT_ROTATED_AT_4_0 =
            "__________\n__BBBB____\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_STRAIGHT_AT_0_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    static final String GRID_WITH_2_STRAIGHTS_AT_BOTTOM =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "BB________\nBB________\nBB________\nBB________\n";

    static final String GRID_WITH_9_STRAIGHTS_AT_BOTTOM =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "BBBBBBBBB_\nBBBBBBBBB_\nBBBBBBBBB_\nBBBBBBBBB_\n";

    static final String GRID_WITH_STRAIGHT_AT_5_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "_____B____\n_____B____\n_____B____\n_____B____\n";

    static final String GRID_WITH_STRAIGHT_AT_0_16_AND_SQUARE_AT_1_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "BRR_______\nBRR_______\nB_________\nB_________\n";

    static final String GRID_WITH_STRAIGHT_AT_5_16_AND_SQUARE_AT_3_16 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "___RRB____\n___RRB____\n_____B____\n_____B____\n";

    static final String GRID_WITH_2_STRAIGHTS_STACKED_AT_0_12 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    static final String GRID_WITH_3_STRAIGHTS_STACKED_AT_0_8 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    static final String GRID_WITH_4_STRAIGHTS_STACKED_AT_0_4 =
            "__________\n__________\n__________\n__________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    static final String GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0 =
            "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n" +
                    "B_________\nB_________\nB_________\nB_________\n";

    static final String GRID_WITH_RIGHT_STEP_AT_0_0 =
            "GG________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_RIGHT_STEP_AT_0_1 =
            "_GG_______\nGG________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_RIGHT_STEP_ROTATED_AT_0_1 =
            "G_________\nGG________\n_G________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_LEFT_STEP_AT_0_0 =
            "MM________\n_MM_______\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_LEFT_STEP_AT_7_0 =
            "_______MM_\n________MM\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_LEFT_STEP_ROTATED_AT_7_0 =
            "________M_\n_______MM_\n_______M__\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_LEFT_STEP_ROTATED_AT_8_0 =
            "_________M\n________MM\n________M_\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_LEFT_STEP_8_0 =
            "_______MM_\n________MM\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_LEFT_STEP_ROTATED_AT_0_0 =
            "_M________\nMM________\nM_________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_AT_0_0 =
            "YYY_______\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_AT_0_1 =
            "_Y________\nYYY_______\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_ROTATED_AT_0_1 =
            "_Y________\n_YY_______\n_Y________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_ROTATED_AT_MINUS1_1 =
            "Y_________\nYY________\nY_________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_ROTATED_TWICE_AT_0_1 =
            "__________\nYYY_______\n_Y________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_AT_1_1 =
            "__Y_______\n_YYY______\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_ROTATED_AT_1_1 =
            "__Y_______\n__YY______\n__Y_______\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_ROTATED_TWICE_AT_1_1 =
            "__________\n_YYY______\n__Y_______\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_ROTATED_THRICE_AT_1_1 =
            "__Y_______\n_YY_______\n__Y_______\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n";

    static final String GRID_WITH_CENTER_STEP_AT_0_19 =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n_Y________\nYYY_______\n";

    static final String GRID_WITH_2_CENTER_STEPS_NEXT_TO_EACH_OTHER_AT_BOTTOM =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n_Y__Y_____\nYYYYYY____\n";

    static final String GRID_WITH_2_CENTER_STEPS_AND_SQUARE_NEXT_TO_EACH_OTHER_AT_BOTTOM =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n_Y__Y_RR__\nYYYYYYRR__\n";

    static final String GRID_WITH_2_CS_2_SQ_HIT_BOTTOM_REMOVED_LAST_LINE =
            "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n__________\n" +
                    "__________\n__________\n__________\n_Y__Y_RRRR\n";

}
