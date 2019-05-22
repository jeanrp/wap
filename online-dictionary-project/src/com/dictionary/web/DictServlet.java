package com.dictionary.web;

import com.dictionary.data.configuration.DbConnection;
import com.dictionary.data.persistence.EntryDbUtil;
import com.dictionary.model.Entry;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DictServlet")
public class DictServlet extends HttpServlet
{
    private EntryDbUtil entryDbUtil;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            entryDbUtil = new EntryDbUtil(new DbConnection());
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String word = request.getParameter("word");
        Entry entry = entryDbUtil.getEntryByWord(word);

        System.out.println(entry);

        String json = new Gson().toJson(entry);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
