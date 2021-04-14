package com.toDoApp.todo;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to manage all the To Dos
 * 
 * */
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Learn Web app development"));
		todos.add(new Todo("Learn spring mvc"));
		todos.add(new Todo("Learn spring Rest"));
	}
	
	public List<Todo> retrieveTodos() {
		return todos;
	}
	
}
