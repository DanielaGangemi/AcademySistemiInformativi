package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.dto.CategoryInsertDto;
import it.corso.dto.CategoryShowDto;
import it.corso.dto.CourseInsertDto;
import it.corso.dto.CourseShowDto;
import it.corso.jwt.JWTTokenNeeded;
import it.corso.jwt.Secured;
import it.corso.service.CourseService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Secured(role = "Admin")
@JWTTokenNeeded
@Path("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GET
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourses() {

		try {

			List<CourseShowDto> courseList = courseService.getCourses();
			return Response.status(Response.Status.OK).entity(courseList).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("Errore caricamento utenti").build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") int id) {

		try {

			CourseShowDto courseShowDto = courseService.findById(id);

			if (courseShowDto != null) {

				return Response.status(Response.Status.OK).entity(courseShowDto).build();

			} else {

				return Response.status(Response.Status.NOT_FOUND).build();

			}

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(@RequestBody CourseInsertDto courseInsertDto) {

		try {

			courseService.insert(courseInsertDto);

			return Response.status(Response.Status.OK).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteByEmail(@PathParam("id") int id) {

		try {

			courseService.delete(id);

			return Response.status(Response.Status.OK).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();

		}

	}

}
