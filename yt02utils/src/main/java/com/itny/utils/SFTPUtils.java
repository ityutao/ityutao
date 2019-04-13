package com.itny.utils;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SFTPUtils {
	/**
	 * 
	 * @param host
	 *            主机
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param port
	 *            端口 默认22
	 * @param uploadDir
	 *            文件服务器的上传路径
	 * @param in
	 *            上传的一个文件流
	 * @param filename
	 *            上传文件的名称
	 * @return
	 * @throws SftpException
	 * @throws JSchException
	 */
	public static String sftpPut(String host, String username, String password, Integer port, String uploadDir,
			InputStream in, String filename) throws SftpException, JSchException {
		// 1.获取会话
		JSch jSch = new JSch();
		Session session = jSch.getSession(username, host, port);
		session.setPassword(password);

		Properties properties = new Properties();
		properties.put("StrictHostKeyChecking", "no");
		session.setConfig(properties);

		session.connect();

		// 2.获取上传的管道
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftp = (ChannelSftp) channel;

		// 3.切换目录
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String subDir = dateFormat.format(new Date());
		try {
			sftp.cd(uploadDir + "/" + subDir);
		} catch (SftpException e) {
			// 目录不存在 新建目录
			try {
				sftp.mkdir(uploadDir + "/" + subDir);
				sftp.cd(uploadDir + "/" + subDir);
			} catch (SftpException e1) {
				throw e1;
			}
		}

		// 4.上传
		sftp.put(in, filename);

		// 5.关闭
		sftp.disconnect();
		channel.disconnect();
		session.disconnect();

		return subDir + "/" + filename;
	}
}
