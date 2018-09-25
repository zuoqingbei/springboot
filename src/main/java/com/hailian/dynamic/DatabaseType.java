package com.hailian.dynamic;

public enum DatabaseType
{
  master("write"), slave("read");

  private String name;

  private DatabaseType(String name) { this.name = name(); }


  public String getName()
  {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}