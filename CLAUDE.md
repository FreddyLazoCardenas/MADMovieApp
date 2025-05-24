# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

MovieApi is an Android application that displays popular movies from The Movie Database (TMDB) API. It follows Clean Architecture principles with a separation of concerns across multiple modules.

## Architecture

The project is structured into four modules:

1. **domain**: Contains business logic, models, repository interfaces, and use cases
2. **data**: Implements repositories, API services, and data mapping
3. **presentation**: Contains UI components (Jetpack Compose), ViewModels, and theme
4. **app**: Entry point to the application, sets up dependency injection

### Clean Architecture Flow

- **UI Layer**: Compose UI → ViewModel
- **Domain Layer**: Use Cases → Repository Interfaces → Domain Models
- **Data Layer**: Repository Implementations → API Services → DTOs/Mappers

## Key Technologies

- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern UI toolkit
- **Hilt**: Dependency injection
- **Retrofit/OkHttp**: Network communication
- **Coroutines/Flow**: Asynchronous programming
- **Coil**: Image loading

## Development Commands

### Build and Run

```bash
# Build the entire project
./gradlew build

# Clean and rebuild
./gradlew clean build

# Install and run on device
./gradlew installDebug

# Run unit tests
./gradlew test

# Run instrumentation tests
./gradlew connectedAndroidTest
```

### Module-specific commands

```bash
# Build specific module
./gradlew :app:build
./gradlew :data:build
./gradlew :domain:build
./gradlew :presentation:build

# Test specific module
./gradlew :app:test
./gradlew :data:test
./gradlew :domain:test
./gradlew :presentation:test
```

## API Configuration

The app requires a TMDB API key to function. The key is stored in `local.properties` file (not in Git) and accessed securely:

```
# Add this to local.properties
MOVIE_API_KEY=your_api_key_here
```

The API key is read at build time and injected using BuildConfig, then used in API requests via the AuthInterceptor.

## Project Structure Details

### Domain Layer

- **Models**: Simple data classes (MovieDomain)
- **Repository Interfaces**: Define data operations (MovieRepository)
- **Use Cases**: Single-purpose business logic (GetPopularMoviesUseCase)

### Data Layer

- **DTOs**: Data transfer objects matching API responses (MovieDto)
- **API Services**: Retrofit interfaces (MovieApiService)
- **Repository Implementations**: Connect API to domain (MovieRepositoryImpl)
- **Mappers**: Convert DTOs to domain models

### Presentation Layer

- **ViewModels**: Manage UI state (MovieViewModel)
- **Screens**: Compose UI components (PopularMoviesScreen)
- **Theme**: App styling

### DI Structure

Hilt modules provide dependencies for:
- Network components (Retrofit, OkHttp)
- Repositories
- ViewModels