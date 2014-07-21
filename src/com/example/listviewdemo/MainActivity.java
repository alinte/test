package com.example.listviewdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView  listView;
	
	private List<Integer> list;
	 int first_num=-1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView  = (ListView)findViewById(R.id.listview);
		
		initData();
		
		setAdapter();
	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		
		MyAdapter adapter = new MyAdapter(list);
		
		listView.setAdapter(adapter);
	}

	class MyAdapter extends BaseAdapter{

		List<Integer> list;
      private LayoutInflater mInflater;
		public   MyAdapter(List<Integer> list)
		{
			
			mInflater =(LayoutInflater)getSystemService
			         (Context.LAYOUT_INFLATER_SERVICE);
			this.list = list;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			 ViewHolder holder = null;
			if (convertView == null) {
				
				if(list.get(position)>0){
						
							if(first_num<0){
								//分组开始
								 convertView = mInflater.inflate(R.layout.advicelist_items1, null);  
								 TextView tv_no = (TextView)convertView.findViewById(R.id.stime);
								 tv_no.setText("组号："+list.get(position));
								 first_num = list.get(position);
								 
							}
							else{
								//如果分组到了列表最后的一个元素则自动认为到了分组结束
								int size = list.size()-1;
								if(position==(size)){
									 convertView = mInflater.inflate(R.layout.advicelist_items3, null);  
									 TextView tv_no = (TextView)convertView.findViewById(R.id.stime);
									 tv_no.setText("组号："+list.get(position));
									 first_num=-1;

								}
								
								else if(list.get(position+1).equals(list.get(position)))
								{
									 convertView = mInflater.inflate(R.layout.advicelist_items2, null);  
									 TextView tv_no = (TextView)convertView.findViewById(R.id.stime);
									 tv_no.setText("组号："+list.get(position));

								}else{
									
									 convertView = mInflater.inflate(R.layout.advicelist_items3, null);  
									 TextView tv_no = (TextView)convertView.findViewById(R.id.stime);
									 tv_no.setText("组号："+list.get(position));
									 first_num=-1;
								}
																
							}
					
				}
				else{
					
					 convertView = mInflater.inflate(R.layout.advicelist_items, null);  
				}

				    holder = new ViewHolder(convertView);
		            convertView.setTag(holder);
	        } else {
	        	
	            holder = (ViewHolder) convertView.getTag();
	        }
			
			    
		        holder.stime.setText("组号："+list.get(position));
		       
	     
			return convertView;
		}
		
		
	}
	 public static class ViewHolder {
	        public TextView stime;
	        public TextView content;
	        public TextView jiliang;
	        public TextView use;
	        public TextView frequent;
	        public TextView makedoctor;
	        public TextView finishdoctor;
	        public TextView endtime;
         public ImageView little_line;
         public ImageView long_line_top;
         public ImageView long_line_bottom;
         
	          ViewHolder(View view) {
	        	  
	            stime=(TextView)view.findViewById(R.id.stime);
	            
	        }
	    }
	
	private void initData() {
		// TODO Auto-generated method stub
		
		list = new ArrayList<Integer>();
		for(int i=0;i<3;i++){
			
			list.add(1);
		}
		for(int i=0;i<7;i++){
			list.add(5);
			
		}
		for(int i=0;i<5;i++)
		{
			list.add(0);
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
