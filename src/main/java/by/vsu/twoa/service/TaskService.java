package by.vsu.twoa.service;

import by.vsu.twoa.dao.DaoException;
import by.vsu.twoa.dao.TaskDao;
import by.vsu.twoa.dao.UserDao;
import by.vsu.twoa.domain.Task;
import by.vsu.twoa.domain.User;
import by.vsu.twoa.geometry.*;
import by.vsu.twoa.service.exception.ServiceException;
import by.vsu.twoa.service.exception.TaskNotExistsException;
import by.vsu.twoa.service.exception.UserNotExistsException;

import java.util.Date;
import java.util.List;

public class TaskService {
	private TaskDao taskDao;
	private UserDao userDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Task> findByOwner(Integer id) throws ServiceException {
		try {
			User owner = userDao.read(id).orElseThrow(() -> new UserNotExistsException(id));
			List<Task> tasks = taskDao.readByOwner(id);
			tasks.forEach(task -> task.setOwner(owner));
			return tasks;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Task findById(Integer id) throws ServiceException {
		try {
			Task task = taskDao.read(id).orElseThrow(() -> new TaskNotExistsException(id));
			task.setOwner(userDao.read(task.getOwner().getId()).orElseThrow(() -> new UserNotExistsException(id)));
			Point vertex1 = task.getVertex1();
			Point vertex2 = task.getVertex2();
			double radius = task.getRadius();
			Point middle = new Segment(vertex1, vertex2).middle();
			Vector v = new Vector(middle, vertex1).rotate(90);
			double c = radius / v.length();
			v.multiply(Math.sqrt(c * c - 1));
			Vector v2 = v.multiply(2);
			task.setRectangleVariant1(new Rectangle(vertex1, vertex2, v2.put(vertex2), v2.put(vertex1)));
			task.setCircumCircleVariant1(new Circle(v.put(middle), radius));
			v = v.multiply(-1);
			v2 = v2.multiply(-1);
			task.setRectangleVariant2(new Rectangle(vertex1, vertex2, v2.put(vertex2), v2.put(vertex1)));
			task.setCircumCircleVariant2(new Circle(v.put(middle), radius));
			return task;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Integer save(Task task) throws ServiceException {
		try {
			if(task.getId() == null) {
				task.setCreated(new Date(0));
				return taskDao.create(task);
			} else {
				throw new RuntimeException("Update operation not implemented yet");
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}
