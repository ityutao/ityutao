package com.itany.book.service;

import java.util.List;
import java.util.Map;

/**
 * Created by tyh on 2018/9/23.
 */
public interface IBookService {

    public void addDoc();

    public List<Map<String,String>> findDoc();

}
