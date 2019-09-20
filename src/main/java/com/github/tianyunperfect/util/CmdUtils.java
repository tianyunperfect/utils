package com.github.tianyunperfect.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * cmd工具类
 *
 * @author tianyunperfect
 */
public class CmdUtils {

    /**
     * 执行并返回结果
     *
     * @param cmd
     * @return
     * @throws Exception
     */
    public static String execute(String cmd) throws Exception {
        Process process = Runtime.getRuntime().exec(cmd);

        //获取返回值
        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    }

    /**
     * 批量执行cmd，并返回结果，默认当前目录
     * cd /home/test
     * pwd
     * rm -fr /home/proxy.log
     *
     * @param commands
     * @return
     */
    public static List<String> executeNewFlow(List<String> commands) throws Exception {
        List<String> rspList = new ArrayList<>();
        Runtime run = Runtime.getRuntime();
        Process proc = run.exec("/bin/bash", null, null);
        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
        for (String line : commands) {
            out.println(line);
        }
        // 这个命令必须执行，否则in流不结束。
        out.println("exit");
        String rspLine;
        while ((rspLine = in.readLine()) != null) {
            System.out.println(rspLine);
            rspList.add(rspLine);
        }
        proc.waitFor();
        in.close();
        out.close();
        proc.destroy();
        return rspList;
    }
}