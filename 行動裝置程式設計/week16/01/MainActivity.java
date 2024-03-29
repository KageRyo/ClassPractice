package com.coderyo.d20231228;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        final EditText usernameET = (EditText) findViewById(R.id.username);// 獲得用戶名控制項
        final EditText passwordET = (EditText) findViewById(R.id.password);// 獲得密碼控制項
        Button login = (Button) findViewById(R.id.login);// 獲得按鈕控制項
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();// 獲得用戶名
                String password = passwordET.getText().toString();// 獲得密碼
                SharedPreferences sp = getSharedPreferences("mrsoft", MODE_PRIVATE);// 獲得私有類型的SharedPreferences
                Editor editor = sp.edit();// 獲得Editor對象
                editor.putString("username", username);// 增加用戶名
                editor.putString("password", password);// 增加密碼
                editor.commit();// 確認提交
                Intent intent = new Intent();// 創建Intent對象
                intent.setClass(MainActivity.this, SharedPreferencesReadActivity.class);// 指定跳轉到SharedPreferencesReadActivity
                startActivity(intent);// 實現跳轉
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
