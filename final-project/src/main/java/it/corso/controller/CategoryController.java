package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.dto.CategoryInsertDto;
import it.corso.dto.CategoryShowDto;
import it.corso.service.CategoryService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GET
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourses(@QueryParam("categoryName") String categoryName) {

		try {

			List<CategoryShowDto> categoryShowDto = new ArrayList<>();

			if (categoryName != null && !categoryName.isEmpty()) {

				categoryShowDto = categoryService.findAllByCategory(categoryName);

			} else {

				categoryShowDto = categoryService.findAll();

			}

			return Response.status(Response.Status.OK).entity(categoryShowDto).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") int id) {

		try {

			CategoryShowDto categoryShowDto = categoryService.findById(id);

			if (categoryShowDto != null) {

				return Response.status(Response.Status.OK).entity(categoryShowDto).build();

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
	public Response registration(@RequestBody CategoryInsertDto categoryInsertDto) {

		try {

			categoryService.insert(categoryInsertDto);

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

			categoryService.delete(id);

			return Response.status(Response.Status.OK).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();

		}

	}

}
