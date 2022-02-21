package com.todo.dao;

import java.util.ArrayList;

import android.R.integer;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.todo.entity.Task;

public class TaskDao {

    private SQLiteDatabase db;

    public TaskDao(SQLiteDatabase db) {
        this.db = db;
        this.db.execSQL("create table if not exists task(tid INTEGER PRIMARY KEY AUTOINCREMENT,task_name text,task_desc text,priority text)");
    }

    public boolean saveTask(Task task)
    {
        boolean f = false;

        try {

            this.db.execSQL("insert into task(task_name,task_desc,priority) values('"+task.getTask_name()+"','"+task.getTask_desc()+"','"+String.valueOf(task.getPriority())+"')");

            this.db.close();

            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }


    public boolean updateTask(Task task)
    {
        boolean f = false;

        try {
            this.db.execSQL("update task set task_name='"+task.getTask_name()+"',task_desc='"+task.getTask_desc()+"',priority='"+String.valueOf(task.getPriority())+"' where tid='"+task.getId()+"'");
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean deleteTask(int id)
    {
        boolean f = false;

        try {
            this.db.execSQL("delete from task where tid='"+id+"'");
            this.db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public Task getTask(int id)
    {
        Task task = new Task();

        try {

            Cursor c = this.db.rawQuery("select * from task where id = '"+id+"'", null);
            if(c.moveToNext())
            {
                task.setId(c.getInt(0));
                task.setTask_name(c.getString(1));
                task.setTask_desc(c.getString(2));
                task.setPriority(Integer.parseInt(c.getString(3)));
            }
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return task;
    }

    public ArrayList<Task> getAllTask()
    {

        ArrayList<Task> alltask = new ArrayList<Task>();
        try {
            Cursor c = this.db.rawQuery("select * from task", null);

            while(c.moveToNext())
            {

                Task task = new Task(c.getInt(0),c.getString(1),c.getString(2),Integer.parseInt(c.getString(3)));
                alltask.add(task);

            }
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alltask;
    }

}
