package com.coderyo.finalexam0111;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CompDBHper extends SQLiteOpenHelper {
//	private static final String DBname = "先進公司.db";
//	private static final int DBversion = 1;
	private static final String TBname = "客戶";
	private static final String crTBsql = 
					"CREATE TABLE " + TBname + " ( " +
					" cusNo VARCHAR(10) NOT NULL, " +
					" cusNa VARCHAR(20) NOT NULL, " +
					" cusPho VARCHAR(20), " +
					" cusAdd VARCHAR(50), PRIMARY KEY (cusNo)); ";

	public CompDBHper(Context context, String DBname, 
			CursorFactory factory, int DBversion) {
//		super(context, DBname, null, DBversion);
		super(context, "先進公司.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(crTBsql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, 
			int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TBname);
		onCreate(db);
	}
	public void createTB() {
		SQLiteDatabase db = getWritableDatabase();		
		ContentValues[] rec = new ContentValues[3];
		for(int i=0; i<rec.length; i++)
			rec[i] = new ContentValues();
		
		rec[0].put("cusNo", "1411068014");
		rec[0].put("cusNa", "張健勳");
		rec[0].put("cusPho", "100");
		rec[0].put("cusAdd", "行動裝置程式設計");
		
		rec[1].put("cusNo", "1410968014");
		rec[1].put("cusNa", "吳美虹");
		rec[1].put("cusPho", "10");
		rec[1].put("cusAdd", "行動裝置程式設計");
		
		rec[2].put("cusNo", "1410868014");
		rec[2].put("cusNa", "許仁均");
		rec[2].put("cusPho", "97");
		rec[2].put("cusAdd", "行動裝置程式設計");
		
		for(ContentValues row : rec){
			db.insert(TBname, null, row);
		}	
		db.close();
	}

	public ArrayList<String> getRecSet(){
		SQLiteDatabase db = getReadableDatabase();
		String sql = "SELECT * FROM " + TBname;
		Cursor recSet = db.rawQuery(sql, null);
		ArrayList<String> recAry = new ArrayList<String>();
		int columnCount = recSet.getColumnCount();
		while(recSet.moveToNext()){
			String fldSet = "";
			for(int i=0; i<columnCount; i++)
				fldSet += recSet.getString(i) + "#";
			recAry.add(fldSet);			
		}
		recSet.close();
		db.close();
		return recAry;		
	}
	public int updateRec(String CusNo,String CusNa,
			String CusPho,String CusAdd){
		SQLiteDatabase db = getWritableDatabase();
		String sql = "SELECT * FROM " + TBname;
		Cursor recSet = db.rawQuery(sql, null);
		if(recSet.getCount()!=0){
			ContentValues rec = new ContentValues();
			rec.put("cusNo", CusNo);
			rec.put("cusNa", CusNa);
			rec.put("cusPho", CusPho);
			rec.put("cusAdd", CusAdd);
			String whereClause = "cusNo='" + CusNo + "'";
			int rowsAffected = db.update(TBname, rec, 
					whereClause, null);
			db.close();
			return rowsAffected;
		}else {
			db.close();
			return -1;
		}
	}
	
	public int deleteRec(String CusNo){
		SQLiteDatabase db = getWritableDatabase();
		String sql = "SELECT * FROM " + TBname;
		Cursor recSet = db.rawQuery(sql, null);
		if(recSet.getCount()!=0){
			String whereClause = "cusNo='" + CusNo + "'";
			int rowsAffected = db.delete(TBname, 
					whereClause, null);
			db.close();
			return rowsAffected;
		}else {
			db.close();
			return -1;
		}
	}
}