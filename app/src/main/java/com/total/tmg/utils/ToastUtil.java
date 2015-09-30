package com.total.tmg.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	public static void showToast(Context context, String res) {
		Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
	}
}
