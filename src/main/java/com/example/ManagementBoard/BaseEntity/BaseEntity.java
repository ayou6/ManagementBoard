package com.example.ManagementBoard.BaseEntity;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    public LocalDateTime createdDate;
    public LocalDateTime updatedDate;
    public boolean isActive;
}
