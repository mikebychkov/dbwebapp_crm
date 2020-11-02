package com.testdb;

import com.store.CustomerDBImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestDBServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(TestDBServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter output = resp.getWriter();
        output.println("Here is the data:");
        try (TestDBStore store = new TestDBStore()) {
            for (String str : store.findAll()) {
                output.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            output.println(e.getLocalizedMessage());
        }
        output.flush();
    }
}
