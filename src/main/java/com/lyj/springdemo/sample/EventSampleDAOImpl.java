package com.lyj.springdemo.sample;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("event")
public class EventSampleDAOImpl implements ISampleDAO{
}
