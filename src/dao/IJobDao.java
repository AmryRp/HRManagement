/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Job;

/**
 *
 * @author amry4
 */
public interface IJobDao {
    public boolean insertOrUpdate(Job j);

    public boolean delete(Job j);

    public List<Job> getAll();

    public List<Job> search(Job j);

    public Job getById(int id);
}
