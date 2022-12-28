package com.example.ToDoList.service;

import com.example.ToDoList.DTO.CommentDto;
import com.example.ToDoList.DTO.PriorityDto;
import com.example.ToDoList.DTO.StatusDto;
import com.example.ToDoList.DTO.TaskDto;
import com.example.ToDoList.entity.Comment;
import com.example.ToDoList.entity.Priority;
import com.example.ToDoList.entity.Status;
import com.example.ToDoList.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class MapperDtoImpl implements MapperDto{

    @Override
    public Task convertTaskDtoToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setStart_date(taskDto.getStart_date());
        task.setEndDate(taskDto.getEnd_date());
        task.setCreatedDate(taskDto.getCreatedDate());
        task.setModifiedDate(taskDto.getModifiedDate());

        Status status = new Status();
        status.setId(taskDto.getStatus_dto().getId());

        Priority priority = new Priority();
        priority.setId(taskDto.getPriority_dto().getId());

        task.setStatus(status);
        task.setPriority(priority);
        return task;
    }

    @Override
    public TaskDto convertTaskToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();

        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setStart_date(task.getStart_date());
        taskDto.setEnd_date(task.getEndDate());
        taskDto.setCreatedDate(task.getCreatedDate());
        taskDto.setModifiedDate(task.getModifiedDate());

        PriorityDto priorityDto = new PriorityDto();
        priorityDto.setId(task.getPriority().getId());
        priorityDto.setPriority(task.getPriority().getPriority());
        priorityDto.setModifiedDate(task.getPriority().getModifiedDate());
        priorityDto.setCreatedDate(task.getPriority().getCreatedDate());
        taskDto.setPriority_dto(priorityDto);

        StatusDto statusDto = new StatusDto();
        statusDto.setId(task.getStatus().getId(1));
        statusDto.setStatus_name(task.getStatus().getStatus());
        statusDto.setModifiedDate(task.getStatus().getModifiedDate());
        statusDto.setCreatedDate(task.getStatus().getCreatedDate());
        taskDto.setStatus_dto(statusDto);
        return taskDto;    }

    @Override
    public Priority convertPriorityDtoToPriority(PriorityDto priorityDto) {
        Priority priority = new Priority();
        priority.setId(priorityDto.getId());
        priority.setPriority(priorityDto.getPriority());
        priority.setPriority(priorityDto.getPriority());
        return priority;
    }

    @Override
    public PriorityDto convertPriorityToPriorityDto(Priority priority) {
        PriorityDto priorityDto = new PriorityDto();
        priorityDto.setId(priority.getId());
        priorityDto.setPriority(priority.getPriority());
        priorityDto.setCreatedDate(priority.getCreatedDate());
        priorityDto.setModifiedDate(priority.getModifiedDate());
        return priorityDto;
    }

    @Override
    public Status convertStatusDtoToStatus(StatusDto statusD) {
        Status status = new Status();
        status.setId(statusD.getId());
        status.setStatus(statusD.getStatus_name());
        status.setCreatedDate(statusD.getCreatedDate());
        status.setModifiedDate(statusD.getModifiedDate());
        return status;
    }

    @Override
    public StatusDto convertStatusToStatusDto(Status status) {
        StatusDto statustDto = new StatusDto();
        statustDto.setId(status.getId(1));
        statustDto.setStatus_name(status.getStatus());
        statustDto.setCreatedDate(status.getCreatedDate());
        statustDto.setModifiedDate(status.getModifiedDate());
        return statustDto;
    }

    @Override
    public Comment convertCommentDtoToComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setComment(commentDto.getComment());
        comment.setCreatedDate(commentDto.getCreatedDate());
        comment.setModifiedDate(commentDto.getModifiedDate());


        return comment;
    }

    @Override
    public CommentDto convertCommentToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setComment(comment.getComment());
        commentDto.setCreatedDate(comment.getCreatedDate());
        commentDto.setModifiedDate(comment.getModifiedDate());

        TaskDto taskDto = new TaskDto();

        taskDto.setId(comment.getTask().getId());
        taskDto.setName(comment.getTask().getName());
        taskDto.setStart_date(comment.getTask().getStart_date());
        taskDto.setEnd_date(comment.getTask().getEndDate());
        taskDto.setModifiedDate(comment.getTask().getModifiedDate());
        taskDto.setCreatedDate(comment.getTask().getCreatedDate());

        StatusDto statusDto = new StatusDto();

        statusDto.setId(comment.getTask().getStatus().getId(1));
        statusDto.setStatus_name(comment.getTask().getStatus().getStatus());
        statusDto.setCreatedDate(comment.getTask().getStatus().getCreatedDate());
        statusDto.setModifiedDate(comment.getTask().getStatus().getModifiedDate());
        taskDto.setStatus_dto(statusDto);

        PriorityDto priorityDto = new PriorityDto();

        priorityDto.setId(comment.getTask().getPriority().getId());
        priorityDto.setPriority(comment.getTask().getPriority().getPriority());
        priorityDto.setCreatedDate(comment.getTask().getPriority().getCreatedDate());
        priorityDto.setModifiedDate(comment.getTask().getPriority().getModifiedDate());
        taskDto.setPriority_dto(priorityDto);

        commentDto.setTask_dto(taskDto);
        return commentDto;
    }
}
