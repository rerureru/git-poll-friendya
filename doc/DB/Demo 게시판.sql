-- phpMyAdmin SQL Dump
-- version 2.11.5.1
-- http://www.phpmyadmin.net
--
-- 호스트: localhost
-- 처리한 시간: 14-07-13 21:21 
-- 서버 버전: 5.5.17
-- PHP 버전: 5.2.14p3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- 데이터베이스: `pyonhae`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `JMBOARD`
--

CREATE TABLE IF NOT EXISTS `JMBOARD` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `WRITER` varchar(50) NOT NULL,
  `SUBJECT` varchar(150) NOT NULL,
  `CONTENT` blob NOT NULL,
  `HITCOUNT` int(11) NOT NULL,
  `RECOMMENDCOUNT` int(11) NOT NULL,
  `WRITEDATE` date NOT NULL,
  `WRITERID` varchar(50) NOT NULL,
  `FILENAME` varchar(100) NOT NULL,
  PRIMARY KEY (`IDX`),
  UNIQUE KEY `JMBOARD_PK` (`IDX`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 테이블의 덤프 데이터 `JMBOARD`
--

INSERT INTO `JMBOARD` (`IDX`, `WRITER`, `SUBJECT`, `CONTENT`, `HITCOUNT`, `RECOMMENDCOUNT`, `WRITEDATE`, `WRITERID`, `FILENAME`) VALUES
(3, '2', '토요일', 0xefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbd, 15, 1, '2014-07-06', '2', '1404605256077'),
(2, '2', '이제 써지겠지?', 0xefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbd, 14, 0, '2014-07-06', '2', '1404576461128'),
(4, '2', '파일테스트', 0xefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbdefbfbd, 12, 0, '2014-07-09', '2', 'DAY04.zip');

-- --------------------------------------------------------

--
-- 테이블 구조 `JMBOARD_COMMENT`
--

CREATE TABLE IF NOT EXISTS `JMBOARD_COMMENT` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `WRITER` varchar(50) NOT NULL,
  `CONTENT` blob NOT NULL,
  `WRITEDATE` date NOT NULL,
  `LINKEDARTICLENUM` int(11) NOT NULL,
  `WRITERID` varchar(50) NOT NULL,
  PRIMARY KEY (`IDX`),
  UNIQUE KEY `JMBOARD_COMMENT_PK` (`IDX`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 테이블의 덤프 데이터 `JMBOARD_COMMENT`
--

INSERT INTO `JMBOARD_COMMENT` (`IDX`, `WRITER`, `CONTENT`, `WRITEDATE`, `LINKEDARTICLENUM`, `WRITERID`) VALUES
(1, '2', 0xec9584ecb9a8, '2014-07-06', 3, '2'),
(3, '333', 0xec9584ec9584, '2014-07-06', 3, '333'),
(5, '2', '', '2014-07-07', 2, '2'),
(6, '2', '', '2014-07-09', 4, '2');

-- --------------------------------------------------------

--
-- 테이블 구조 `JMBOARD_MEMBER`
--

CREATE TABLE IF NOT EXISTS `JMBOARD_MEMBER` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(70) NOT NULL,
  `USERPW` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `JOINDATE` date DEFAULT NULL,
  PRIMARY KEY (`IDX`),
  UNIQUE KEY `JMBOARD_MEMBER_PK` (`IDX`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 테이블의 덤프 데이터 `JMBOARD_MEMBER`
--

INSERT INTO `JMBOARD_MEMBER` (`IDX`, `USERID`, `USERPW`, `USERNAME`, `JOINDATE`) VALUES
(1, '1', '1', '1', '2014-06-19'),
(2, '2', '2', '2', '2014-07-04'),
(3, '333', '333', '333', '2014-07-04');

-- --------------------------------------------------------

--
-- 테이블 구조 `servers`
--

CREATE TABLE IF NOT EXISTS `servers` (
  `Server_name` char(64) NOT NULL,
  `Host` char(64) NOT NULL,
  `Db` char(64) NOT NULL,
  `Username` char(64) NOT NULL,
  `Password` char(64) NOT NULL,
  `Port` int(4) DEFAULT NULL,
  `Socket` char(64) DEFAULT NULL,
  `Wrapper` char(64) NOT NULL,
  `Owner` char(64) NOT NULL,
  PRIMARY KEY (`Server_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='MySQL Foreign Servers table';

--
-- 테이블의 덤프 데이터 `servers`
--


-- --------------------------------------------------------

--
-- 테이블 구조 `temp1`
--

CREATE TABLE IF NOT EXISTS `temp1` (
  `aa` varchar(8) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `temp1`
--
